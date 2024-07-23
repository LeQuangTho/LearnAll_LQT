using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Player : MonoBehaviour
{
    private float speed = 10f;
    public float jumb = 12f;
    private int countScore = 0;
    private Text txtScore;
    private Text txtHightScore;
    private Text txtHeart;
    private Animator anim;

    public bool grounded = true;
    public bool doubleJumb = false;

    private int ourHeart;
    public int maxHealth = 5;

    private SoundManager sound;
    public GameObject BodyMario;

    // Start is called before the first frame update
    void Start()
    {
        //lấy ra Component
        txtScore = GameObject.Find("textScore").GetComponent<Text>();
        txtHightScore = GameObject.Find("txtHightScore").GetComponent<Text>();
        txtHeart = GameObject.Find("txtHeath").GetComponent<Text>();
        anim = BodyMario.GetComponent<Animator>();

        //chỗ này là để test nếu xuất bản thì phải xóa
        PlayerPrefs.SetInt("hightscore", 0);
        txtHightScore.text = ("Hight Score: " + PlayerPrefs.GetInt("hightscore"));

        // xét điểm hiện tại, nếu chưa có biến này thì nó sẽ lấy mặc định là 0
        countScore = PlayerPrefs.GetInt("currentScore", 0);
        txtScore.text = "Score: " + PlayerPrefs.GetInt("currentScore", 0);

        // xét mạng hiện tại, nếu chưa có biến này thì nó sẽ lấy mặc định là 5
        ourHeart = PlayerPrefs.GetInt("currentHeart", 5);
        txtHeart.text = "" + PlayerPrefs.GetInt("currentHeart", 5);

        sound = GameObject.FindGameObjectWithTag("Sound").GetComponent<SoundManager>();
    }

    private void Update()
    {
        anim.SetBool("Grounded", grounded);

        if (Input.GetKeyDown(KeyCode.Space))
        {
            if (grounded)
            {
                grounded = false;
                doubleJumb = true;
                gameObject.GetComponent<Rigidbody2D>().velocity
                      = new Vector2(gameObject.GetComponent<Rigidbody2D>().velocity.x, jumb);
            }
            else
            {
                if (doubleJumb)
                {
                    doubleJumb = false;
                    gameObject.GetComponent<Rigidbody2D>().velocity
                      = new Vector2(gameObject.GetComponent<Rigidbody2D>().velocity.x, jumb * 0.5f);
                }
            }
        }
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        if (Input.GetKey(KeyCode.RightArrow))
        {
            anim.SetBool("Walk", true);
            gameObject.transform.Translate(Vector2.right * speed * Time.deltaTime);
            if (gameObject.transform.localScale.x < 0)
            {
                gameObject.transform.localScale = new Vector2(gameObject.transform.localScale.x * -1, gameObject.transform.localScale.y);
            }
        }
        else if (Input.GetKey(KeyCode.LeftArrow))
        {
            anim.SetBool("Walk", true);
            gameObject.transform.Translate(Vector2.left * speed * Time.deltaTime);
            if (gameObject.transform.localScale.x > 0)
            {
                gameObject.transform.localScale = new Vector2(gameObject.transform.localScale.x * -1, gameObject.transform.localScale.y);
            }
        }
        else
        {
            anim.SetBool("Walk", false);
        }

        if (ourHeart <= 0)
        {
            Death();
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "Coin")
        {
            sound.Playsound("Coin");
            upScore();
            Destroy(collision.gameObject);
        }

        if (collision.gameObject.tag == "BodyGomba" || collision.gameObject.tag == "BodyTurtle")
        {
            txtHeart.text = "" + --ourHeart;
        }

    }


    /*
     *  Hàm này sẽ tăng điểm lên và nếu điểm 
     *  cao hơn điểm cao thì set vào điểm cao
     */
    private void upScore()
    {
        txtScore.text = "Score: " + ++countScore;
        PlayerPrefs.SetInt("currentScore", countScore);
        if (PlayerPrefs.GetInt("hightscore") < countScore)
        {
            PlayerPrefs.SetInt("hightscore", countScore);
            txtHightScore.text = ("Hight Score: " + PlayerPrefs.GetInt("hightscore"));
        }
    }
    
    // check khi player nhảy thoát khỏi bệ đá
    private void OnTriggerExit2D(Collider2D collision)
        {
            if (collision.gameObject.CompareTag("MovingPlat"))
            {
                gameObject.transform.parent = null;
            }
        }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        
        // check khi player dung len thi di chuyển theo
        if (collision.gameObject.tag == "MovingPlat" && grounded)
        {
            grounded = false;
            gameObject.transform.parent = collision.gameObject.transform;
        }
        
        // chạm tột của Thọ thì chuyển map
        if (collision.gameObject.tag == "finalMapThor")
        {
            SceneManager.LoadScene("MapSkyHuy");
        }

        // chạm princess thì EndGame
        if (collision.gameObject.tag == "princess")
        {
            SceneManager.LoadScene("EndStory");
        }

        // chạm thì end map Huy
        if (collision.gameObject.tag == "finalMapHuy")
        {
            SceneManager.LoadScene("Map2_phu");
        }

        //chạm bottom thì replace
        if (collision.gameObject.tag == "Bottom")
        {
            --ourHeart;
            PlayerPrefs.SetInt("currentHeart", ourHeart);
            SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
        }

        //nhảy lên đầu con nấm thì nhảy lên cái nữa
        if (collision.gameObject.tag == "HeadGomba" || collision.gameObject.tag == "HeaderTurtle")
        {
            gameObject.GetComponent<Rigidbody2D>().velocity
                      = new Vector2(gameObject.GetComponent<Rigidbody2D>().velocity.x, jumb);
        }

        //Cộng mạng
        if(collision.gameObject.tag == "heart")
        {
            txtHeart.text = "" + ++ourHeart;
            Destroy(collision.gameObject);
        }
    }

    //chết thì kiểm  tra điểm cao, load lại game
    public void Death()
    {
        if (PlayerPrefs.GetInt("hightscore") < countScore)
        {
            PlayerPrefs.SetInt("hightscore", countScore);
        }

        PlayerPrefs.SetInt("currentScore", 0);
        PlayerPrefs.SetInt("currentHeart", 5);

        SceneManager.LoadScene("PlayGame");
    }
}

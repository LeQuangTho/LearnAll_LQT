using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerMoveKeyBoard : MonoBehaviour
{
    private float speed = 100f;
    private float jumb = 10f;
    private Animator player;
    private float diem = 0f;
    private Text txtDiem;

    // Start is called before the first frame update
    void Start()
    {
        player = GetComponent<Animator>();
        txtDiem = GameObject.Find("txtScore").GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.RightArrow))
        {
            gameObject.transform.Translate(Vector2.right * speed * Time.deltaTime);
            if(gameObject.transform.localScale.x < 0)
            {
                gameObject.transform.localScale = new Vector2(gameObject.transform.localScale.x * -1, gameObject.transform.localScale.y);
            }
        }
        else if (Input.GetKeyDown(KeyCode.LeftArrow))
        {
            gameObject.transform.Translate(Vector2.left * speed * Time.deltaTime);
            if (gameObject.transform.localScale.x > 0)
            {
                gameObject.transform.localScale = new Vector2(gameObject.transform.localScale.x * -1, gameObject.transform.localScale.y);
            }
        }
        else if(Input.GetKeyDown(KeyCode.Space))
        {
            gameObject.GetComponent<Rigidbody2D>().velocity
                = new Vector2(gameObject.GetComponent<Rigidbody2D>().velocity.x, jumb);
        }    
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "Coin")
        {
            Destroy(collision.gameObject);
            txtDiem.text = "Score: " + ++diem;
        }
    }
    
}

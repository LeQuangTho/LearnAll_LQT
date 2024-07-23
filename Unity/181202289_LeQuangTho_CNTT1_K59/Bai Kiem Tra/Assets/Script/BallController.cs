using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class BallController : MonoBehaviour
{
    private Rigidbody2D rb;
    public float speed;
    public Transform Explosion;
    public GameManager gameManager;
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        rb.AddForce(Vector2.up * speed);
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.Escape))
        {
            SceneManager.LoadScene("SampleScene");
            Time.timeScale = 1 ;
        }
    }


    private void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.CompareTag("bottom-die"))
        {
            gameManager.gameOver();
            Time.timeScale = 0;
        }       
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.transform.CompareTag("brick"))
        {
            Transform newExplosion = Instantiate (Explosion, collision.transform.position, collision.transform.rotation);
           
            Destroy(newExplosion.gameObject, 2f);

            gameManager.upScore(1);

            Destroy(collision.gameObject);
        }
    }
}

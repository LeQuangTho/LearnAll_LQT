using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float speed;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.RightArrow))
        {
            if (gameObject.transform.position.x > 8.20f)
            {
                gameObject.transform.position = new Vector2(gameObject.transform.position.x - speed * Time.deltaTime, gameObject.transform.position.y);
            }
            else
            {
                gameObject.transform.position = new Vector2(gameObject.transform.position.x + speed * Time.deltaTime, gameObject.transform.position.y);
            }
        }
        else if (Input.GetKey(KeyCode.LeftArrow))
        {
            if (gameObject.transform.position.x < -8.20f)
            {
                gameObject.transform.position = new Vector2(gameObject.transform.position.x + speed * Time.deltaTime, gameObject.transform.position.y);
            }
            else
            {
                gameObject.transform.position = new Vector2(gameObject.transform.position.x - speed * Time.deltaTime, gameObject.transform.position.y);
            }
        }
    }
}

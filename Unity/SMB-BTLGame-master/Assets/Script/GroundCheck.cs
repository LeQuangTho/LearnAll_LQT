using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GroundCheck : MonoBehaviour
{
    private Player player;
    public GameObject mario;
    // Start is called before the first frame update
    void Start()
    {
        player = mario.GetComponentInParent<Player>();
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        player.grounded = true;
        if(collision.gameObject.tag == "downOngKhoi")
        {
            SceneManager.LoadScene("PhuMap");
        }
        if(collision.gameObject.tag == "upOngKhoi")
        {
            SceneManager.LoadScene("Map2_phu2");
        } 
        if(collision.gameObject.tag == "upOngKhoiEnd")
        {
            SceneManager.LoadScene("Map_Phu_End");
        }
    }

    private void OnTriggerStay2D(Collider2D collision)
    {
        player.grounded = true;
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        player.grounded = false;
    }

    
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CDNgang : MonoBehaviour
{
    public float VatVanToc;
    public bool DiChuyenTrai = true;

    // Start is called before the first frame update
    void Start()
    {
       
    }

    private void FixedUpdate()
    {
        Vector2 Dichuyen = transform.localPosition;
        if (DiChuyenTrai)
        {
            Dichuyen.x -= VatVanToc * Time.deltaTime;
        }
        else
        {
            Dichuyen.x += VatVanToc * Time.deltaTime;
        }
        transform.localPosition = Dichuyen;
    }

    private void OnCollisionEnter2D(Collision2D collision)

    {
        if(collision.contacts[0].normal.x > 0)
        {
            //DiChuyenTrai = false;
            QuayMat(); 
            DiChuyenTrai = false;
            
        }
        else
        {
            QuayMat();
            
            DiChuyenTrai = true;
            
        }
    }

    void QuayMat()
    {
        DiChuyenTrai = !DiChuyenTrai;
        Vector2 HuongQuay = transform.localScale;// lay huong quay hien tai
        HuongQuay.x *= -1;
        transform.localScale = HuongQuay;
    }    

    // Update is called once per frame
    void Update()
    {
        
    }
}

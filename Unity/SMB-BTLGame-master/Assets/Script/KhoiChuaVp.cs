using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KhoiChuaVp : MonoBehaviour
{
    private Vector3 ViTriLucDau;
    public GameObject khoiRong;
    public GameObject dongXu;


    //cac bien gan item cho vat pham
    
    //public int SoLuongXu = 1;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    //dung contact de kiem tra va cham o vi tri nao y>0 la phia duoi , y<0 la o phia tren, x>0 la trai, x<0 ve phai
    //neu nhu doi tuong mario va cham phia duoi
    private void OnCollisionEnter2D(Collision2D collision)
    {
        //neu nhu doi tuong mario va cham phia duoi
        if (collision.collider.tag == "MarioPlayer" && collision.contacts[0].normal.y>0)
        {
            ViTriLucDau = transform.position;
            GameObject KhoiRong = (GameObject)Instantiate(khoiRong);
            KhoiRong.transform.position = ViTriLucDau;
            GameObject DongXu = (GameObject)Instantiate(dongXu);
            DongXu.transform.position = ViTriLucDau;
            Destroy(collision.gameObject);
        }
    }
}
 

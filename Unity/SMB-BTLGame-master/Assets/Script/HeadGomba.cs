using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HeadGomba : MonoBehaviour
{
    public GameObject BodyGomba;
    public GameObject Gomba;
    Animator anim;
    // Start is called before the first frame update
    void Start()
    {
        anim = BodyGomba.GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "BottomMario")
        {
            anim.SetBool("isDie", true);
            Gomba.GetComponent<GombaMoving>().isMove = false;
            StartCoroutine(destroyNam());
        }
    }


    IEnumerator destroyNam()
    {
        yield return new WaitForSeconds(0.5f);
        Destroy(Gomba);
    }
}

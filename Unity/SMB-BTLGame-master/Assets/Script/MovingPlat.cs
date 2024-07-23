using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovingPlat: MonoBehaviour
{
    public float speed = 0.012f, changeDirection = -1;
    Vector3 Move;

    // Start is called before the first frame update
    void Start()
    {
        Move = this.transform.position;//khởi tạo biến
    }

    // Update is called once per frame
    void Update()
    {
        //dịch chuyển move sau mỗi time nhất định
        Move.x += speed;
        this.transform.position = Move;
    }

    private void OnCollisionEnter2D(Collision2D col)
    {
        // khi va chạm sẽ quay ngược lại 
        if (col.gameObject.tag == "Ground")
        {
            speed *= changeDirection;
        }
    }
}

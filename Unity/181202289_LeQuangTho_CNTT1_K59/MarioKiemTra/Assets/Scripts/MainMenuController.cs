using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainMenuController : MonoBehaviour
{
    public void StartGame()
    {
        //chuyển màn hình
        Application.LoadLevel("ScenePlay");
    }
    public void ReplayGame()
    {
        //chuyển màn hình
        Application.LoadLevel("MainScene");
    }

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        
    }
}

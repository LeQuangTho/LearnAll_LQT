using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEditor.SceneManagement;
using UnityEngine.SceneManagement;

public class PauseUI : MonoBehaviour
{

    private bool pause = false;
    public GameObject pauseUI;
    // Start is called before the first frame update
    void Start()
    {
        pauseUI.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            Pause();
        }

        if (pause)
        {
            pauseUI.SetActive(true);
            Time.timeScale = 0;
        }
        else if (!pause)
        {
            pauseUI.SetActive(false);
            Time.timeScale = 1f;
        }
    }

    public void Pause()
    {
        pause = !pause;
    }

    public void Resume()
    {
        pause = false;
    }

    public void Restart()
    {
        EditorSceneManager.LoadScene(EditorSceneManager.GetActiveScene().buildIndex);
    }

    public void Quit()
    {
        SceneManager.LoadScene("MainMenu");
    }
}

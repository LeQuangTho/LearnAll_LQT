using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    private int score;
    public Text scoreText;
    public Text newHightScoreText;
    public Text hightScoreText;

    public GameObject gameOverGameObject;
    public GameObject newHightScoreGameObject;

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void upScore(int s)
    {
        score += s;
        scoreText.text = "Score: " + score;
        /*int hightScore = PlayerPrefs.GetInt("Hight_Score");
        if (score > hightScore)
        {
            PlayerPrefs.SetInt("Hight_Score", score);
            hightScoreText.text = "Hight Score: " + score;
        }*/
    }

    public void gameOver()
    {
        gameOverGameObject.SetActive(true);
        int hightScore = PlayerPrefs.GetInt("Hight_Score");
        if (score > hightScore)
        {
            newHightScoreText.text = "New Hight Score: " + score;
            newHightScoreGameObject.SetActive(true);
        }
    }

    public void quitGame()
    {
        Time.timeScale = 1;
        SceneManager.LoadScene("Main");
    }

    public void playAgainGame()
    {
        Time.timeScale = 1;
        SceneManager.LoadScene("SampleScene");
    }
}

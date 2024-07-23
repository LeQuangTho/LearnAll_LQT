using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SoundManager : MonoBehaviour
{
    public AudioClip coin, jumb, die;

    public AudioSource adisrc;

    // Start is called before the first frame update
    void Start()
    {
        adisrc = GetComponent<AudioSource>();
    }

    public void Playsound(string clip)
    {
        switch(clip)
        {
            case "Coin":
                adisrc.PlayOneShot(coin, 0.6f);
                break;
            case "jumb":
                adisrc.PlayOneShot(jumb, 0.6f);
                break;
            case "die":
                adisrc.PlayOneShot(die, 0.6f);
                break;
        }    
    }
}

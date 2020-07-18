using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FruitCollected : MonoBehaviour
{
    private void OnTriggerEnter2D(Collider2D collision)
    //colicion entre las frutas y el player 
    {
        if (collision.CompareTag("Player"))
        //para que collisione con el "player" usamos un CompareTag 

        {
            GetComponent<SpriteRenderer>().enabled = false;
            // Desactivamos el sprite renderer; para que la fruta desaparesca una vez colisione.
            gameObject.transform.GetChild(0).gameObject.SetActive(true);
            // para activar la animacion el objeto collected  
            Destroy(gameObject, 0.5f);
            //  para eliminar la fruta; una vez colisionemos usamos un destroy en un tiempo de 0.5 segundos.
        }
    }
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour
{

    public float runSpeed = 2; //el personaje pueda moverse usamos una variable llamada runSpeed; dandole un valor de 2.
    public float jumpSpeed = 3;//el personaje pueda saltar usamos un jumpSpeed; dandole un valor de 3.

    Rigidbody2D rb2D; // hacemos referencia a un Rigidbody

    public bool betterJump = false; //usamos el betterJump para mejorar el salto 

    public float fallMultiplier = 0.5f; //tanto fallMultiplier como lowJumpMultiplier haran que si pulsamos mas o poco el espacio
    public float lowJumpMultiplier = 1f;// caigamos mas rapido o mas lento.
    public SpriteRenderer spriteRenderer;// referenciamos el spriteRenderer para usar el componente flip

    public Animator animator; // referenciamos al componente animator 


    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
        // para iniciar va a buscar dentro del personaje el componete Rigidbody y lo va a ejecutar.
    }


    void FixedUpdate()
    // para el movimiento usamos un FixedUpdate donde :
    {
        if (Input.GetKey("d") || Input.GetKey("right"))
        // le indicamos que al pulsar "d" o "fecha derecha"  
        // el rigidbody se mueva y hacemos un nuevo vector2 para decirle en que direccion queremos ir.
        // (en el eje "X" le asignamos el runSpeed) y (en el "Y" lo dejamos asi).
        {
            rb2D.velocity = new Vector2(runSpeed, rb2D.velocity.y);
            spriteRenderer.flipX = false; 
            // para q el personaje pueda mira a la izq y a la derecha activamos y desactivamos el flipX
        }
        else if (Input.GetKey("a") || Input.GetKey("left"))
        // le indicamos que al pulsar "a" o "fecha izquierda"
        // se dirija hacia la izquierda por lo cual el runSpeed es negativo.
        {
            rb2D.velocity = new Vector2(-runSpeed, rb2D.velocity.y);
            spriteRenderer.flipX = true;// aqui estaria activado el flipX y el personaje miraria hacia la izquierda.   
        }
        else
        {
            rb2D.velocity = new Vector2(0, rb2D.velocity.y);
            // y si no pulsamos nada lo dejamos en la posicion 0 .
        }
        if (Input.GetKey("space") && CheckGround.isGrounded)
            // le indicamos que cuando pulsemos espacio y este el suelo podremos saltar.
        {
            rb2D.velocity = new Vector2(rb2D.velocity.x, jumpSpeed);
            // mantenemos el eje x y cambiamos el eje Y 
        }
        if (betterJump) //si el betterJump esta activado se realizara este tipo de salto
        {
            if(rb2D.velocity.y<0) // si nuestra velocidad en el eje y es mejor de 0; se usara un Multiplier distinto al otro
            {
                rb2D.velocity += Vector2.up * Physics2D.gravity.y * (fallMultiplier) * Time.deltaTime;
                // le indicamos q salte mas rapido o mas lento dependiendo del frame 
            }
            if(rb2D.velocity.y>0 && !Input.GetKey("space"))// si es mayor se usara el lowJumpMultiplier 
            {
                rb2D.velocity += Vector2.up * Physics2D.gravity.y * (lowJumpMultiplier) * Time.deltaTime;
            }

        }

    }
}



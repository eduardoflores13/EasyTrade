package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var signInOptions:GoogleSignInOptions
    private lateinit var signInClient:GoogleSignInClient
    val RC_SIGN_IN: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var linkcuenta:TextView = findViewById(R.id.linkcuenta)
        linkcuenta.setText(R.string.cuenta)
        val intentCrearCuenta = Intent(this, crearcuenta_activity::class.java)

        auth = FirebaseAuth.getInstance()
        initializeUI()
        setupGoogleLogin()

        linkcuenta.setOnClickListener {
            linkcuenta.setText(R.string.cuentau)
            startActivity(intentCrearCuenta)
        }
    }

    override fun onStart(){
        super.onStart()
        //ING: "Validar que no exista otra instancia corriendo"
        val usuario = FirebaseAuth.getInstance().currentUser
        if(usuario != null){
            val intentInicio = Intent(this, intercambios_activity::class.java)
            startActivity(intentInicio)
        }
    }

    private fun setupGoogleLogin(){
        signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(this, signInOptions)
    }

    private fun initializeUI(){
        google_button.setOnClickListener{
            login()
        }
    }

    private fun login(){
        val loginIntent: Intent = signInClient.signInIntent
        startActivityForResult(loginIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN){
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                if(account != null){
                    googleFirebaseAuth(account)
                }
            } catch (e: ApiException){
                Toast.makeText(this, "El inicio de sesión ha fallado", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun googleFirebaseAuth(acct: GoogleSignInAccount){
        val credenciales = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credenciales).addOnCompleteListener{
            if (it.isSuccessful){
                val intentnext = Intent(this, registro_activity::class.java)
                startActivity(intentnext)
            }else{
                Toast.makeText(this, "Fallo de inicio de sesión", Toast.LENGTH_LONG).show()
            }
        }
    }
}
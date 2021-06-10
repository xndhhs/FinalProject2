package ro.iss.finalchallenge.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_screen.*
import ro.iss.finalchallenge.R
import ro.iss.finalchallenge.dashboard.Dashboard


class LoginScreen : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        firebaseAuth = FirebaseAuth.getInstance()
        login_button.setOnClickListener {
            if (email_text_view.text.isNullOrBlank() || password_text_view.text.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "please fill provide the username and password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                loginUser(email_text_view.text.toString(), password_text_view.text.toString())
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(
            email_text_view.text.toString(),
            password_text_view.text.toString()
        )
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    val goToDashboard = Intent(applicationContext, Dashboard::class.java)
                    startActivity(goToDashboard)

                } else {
                    Toast.makeText(this@LoginScreen, "Error!", Toast.LENGTH_SHORT).show()
                }
            }
    }

}



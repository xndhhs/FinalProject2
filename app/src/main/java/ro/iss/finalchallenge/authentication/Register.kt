package ro.iss.finalchallenge.authentication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.registration_form.*
import ro.iss.finalchallenge.R





class Register : AppCompatActivity() {
    lateinit var firstName: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var lastName: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var country: TextInputEditText
    lateinit var birthday: TextInputEditText
    lateinit var profession: TextInputEditText
    lateinit var submitButton: Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_form)

        firstName = findViewById(R.id.first_name_text_view)
        lastName = findViewById(R.id.last_name_text_view)
        email = findViewById(R.id.email_text_view)
        password = findViewById(R.id.password_text_view)
        country = findViewById(R.id.country_text_view)
        birthday = findViewById(R.id.birth_date_text_view)
        profession = findViewById(R.id.profession_text_view)
        submitButton = findViewById(R.id.submit_registration_button)

        firebaseAuth = FirebaseAuth.getInstance()

        submitButton.setOnClickListener {
            var userEmail = email.text.toString()
            var userPassword = password.text.toString()
            var userFirstName = firstName.text.toString()
            var userLastName = lastName.text.toString()
            var userCountry = country.text.toString()
            var userBirthday = birthday.text.toString()
            var userProfession = profession.text.toString()

            //register to Firebase
//            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
//                .addOnCanceledListener {
//                    val task: Task<AuthResult>
//                    if (task.isSuccessful) {
//                        Toast.makeText(this, "USER CREATED", Toast.LENGTH_SHORT).show()
//                        val goToLogin = Intent(applicationContext, LoginScreen::class.java)
//                        startActivity(goToLogin)
//
//                    } else {
//                        Toast.makeText(this, "USER CREATED"+ (task.exception?.message), Toast.LENGTH_SHORT).show()
//                    }
//                }
        }


    }
}
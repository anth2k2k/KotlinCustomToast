package com.viettel.learning.kotlincustomtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.viettel.learning.kotlincustomtoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {

        binding.buttonSuccessToast.setOnClickListener {
            showToast(Constants.TOAST_TYPE_SUCCESS, "Success Toast")
        }

        binding.buttonWarningToast.setOnClickListener {
            showToast(Constants.TOAST_TYPE_WARNING, "Warning Toast")
        }

        binding.buttonErrorToast.setOnClickListener {
            showToast(Constants.TOAST_TYPE_ERROR, "Error Toast")
        }
    }

    private fun showToast(toastType: Int, message: String) {
        val toastView = layoutInflater.inflate(
            R.layout.layout_toast,
            findViewById(R.id.linearLayoutToastContainer)
        )

        val linearLayoutToastContainer =
            toastView.findViewById<LinearLayout>(R.id.linearLayoutToastContainer)
        val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
        val textMessage = toastView.findViewById<TextView>(R.id.textMessage)

        when (toastType) {
            Constants.TOAST_TYPE_SUCCESS -> {
                linearLayoutToastContainer.setBackgroundResource(R.drawable.toast_success_background)
                imageIcon.setImageResource(R.drawable.ic_success_toast)
            }
            Constants.TOAST_TYPE_WARNING -> {
                linearLayoutToastContainer.setBackgroundResource(R.drawable.toast_warning_background)
                imageIcon.setImageResource(R.drawable.ic_warning_toast)
            }
            Constants.TOAST_TYPE_ERROR -> {
                linearLayoutToastContainer.setBackgroundResource(R.drawable.toast_error_background)
                imageIcon.setImageResource(R.drawable.ic_error_toast)
            }
        }
        textMessage.text = message

        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }
}
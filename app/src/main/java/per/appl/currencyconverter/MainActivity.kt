package per.appl.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    private val americanDollar = "American Dollar"
    private val AED = "AED"
    private val GBP = "GBP"
    private val egy = "Egyptian Pound"
    private lateinit var DropDownMenu: AutoCompleteTextView
    private lateinit var DropDownMenu1: AutoCompleteTextView
    private lateinit var convertButton: Button
    private lateinit var amounts: TextInputEditText
    private lateinit var res: TextInputEditText

    private val values = mapOf(
        americanDollar to 1.0, AED to 3.67, GBP to 0.84, egy to 19.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        populateDropDownMenu()
        amounts.addTextChangedListener {
            `calculate-number`()
        }
        DropDownMenu.setOnItemClickListener { parent, view, position, id ->
        `calculate-number`()}
        DropDownMenu1.setOnItemClickListener { parent, view, position, id ->
            `calculate-number`()
        }
    }

    private fun populateDropDownMenu() {
        val listDropDown = listOf(egy, americanDollar, AED, GBP)
        val adapter = ArrayAdapter(this, R.layout.drop_down_menu, listDropDown)
        DropDownMenu1.setAdapter(adapter)
        DropDownMenu.setAdapter(adapter)

    }

    private fun `calculate-number`() {

        if (amounts.text.toString().isNotEmpty()) {
            val amount = amounts.text.toString().toDouble()
            val toValue = values[DropDownMenu.text.toString()]
            val fromValue = values[DropDownMenu1.text.toString()]

            try {


                val result = amount * (toValue!! / fromValue!!)

                res.setText(result.toString())

            } catch (ex: Exception) {
//               val snack= Snackbar.make(DropDownMenu, "this a7a", Snackbar.LENGTH_SHORT)
//                snack.show()
//              snack.setAction("OK")
//              {
//
//              }

            }
        } else {
            amounts.setError("Enter a number please")
        }
    }

    private fun initializeViews() {
        convertButton = findViewById(R.id.button)
        amounts = findViewById(R.id.amount_TF)
        res = findViewById(R.id.Result_text)
        DropDownMenu1 = findViewById(R.id.autocomp)
        DropDownMenu = findViewById(R.id.ToComp)
    }

}


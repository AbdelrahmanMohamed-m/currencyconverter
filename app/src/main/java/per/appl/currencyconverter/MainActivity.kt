package per.appl.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val americanDollar = "American Dollar"
    private val AED = "AED"
    private val GBP = "GBP"
    private val EgyptianPound = "Egyptian Pound"

    lateinit var DropDownMenu: AutoCompleteTextView
    lateinit var DropDownMenu1: AutoCompleteTextView
    lateinit var convertButton: Button
    lateinit var amounts: TextInputEditText
    lateinit var res: TextInputEditText

    val values = mapOf(
        americanDollar to 1.0,
        EgyptianPound to 19,
        AED to 3.67,
        GBP to 0.84
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initlizeviews()
        PopulateDropDownMenu()
       amounts.addTextChangedListener {
            `calculate-number`()
        }
        DropDownMenu.setOnItemClickListener { parent, view, position, id ->
        `calculate-number`()}
        DropDownMenu1.setOnItemClickListener { parent, view, position, id ->
            `calculate-number`()
        }
        }


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
    private fun PopulateDropDownMenu() {
        val listDropDown = listOf(EgyptianPound, americanDollar, AED, GBP)
        val adapter = ArrayAdapter(this, R.layout.drop_down_menu, listDropDown)
        DropDownMenu1.setAdapter(adapter)
        DropDownMenu.setAdapter(adapter)

    }

    private fun initlizeviews() {
        convertButton = findViewById(R.id.button)
        amounts = findViewById(R.id.amount_TF)
        res = findViewById(R.id.Result_text)
        DropDownMenu1 = findViewById(R.id.autocomp)
        DropDownMenu = findViewById(R.id.ToComp)
}
}


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
        convertButton.setOnClickListener {
            val amount = amounts.text.toString().toDouble()
            val toValue = values[DropDownMenu1.text.toString()]
            val fromValue= values[DropDownMenu.text.toString()]
            val result = amount.times(toValue!!.div(fromValue!!))
               res.setText(result.toString())
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


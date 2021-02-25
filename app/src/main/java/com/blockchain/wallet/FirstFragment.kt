package com.blockchain.wallet

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_first, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val candleStickChart = view.findViewById<CandleStickChart>(R.id.candleStickChart)
		//x value
		val xvalue = ArrayList<String>()
		xvalue.add("03:00 AM")
		xvalue.add("04:00 AM")
		xvalue.add("05:00 AM")
		xvalue.add("06:00 AM")
		xvalue.add("07:00 AM")
		xvalue.add("08:00 AM")
		xvalue.add("09:00 AM")
		xvalue.add("10:00 AM")

		//Y axis
		val yValsCandleStick = ArrayList<CandleEntry>()
		/*yValsCandleStick.add(CandleEntry(0f, 225.0f, 219.84f, 224.94f, 221.07f))
		yValsCandleStick.add(CandleEntry(1f, 228.35f, 222.57f, 223.52f, 226.41f))
		yValsCandleStick.add(CandleEntry(2f, 226.84f, 222.52f, 225.75f, 223.84f))
		yValsCandleStick.add(CandleEntry(3f, 222.95f, 217.27f, 222.15f, 217.88f))
		yValsCandleStick.add(CandleEntry(4f, 222.95f, 217.27f, 222.15f, 217.88f))
		yValsCandleStick.add(CandleEntry(5f, 222.95f, 217.27f, 222.15f, 217.88f))*/
		val size = xvalue.size

		for (i in 0 until size) {
			val mul = size + 10
			val value = (Math.random() * 100).toFloat() + mul
			val high = (Math.random() * 15).toFloat() + 9f
			val low = (Math.random() * 15).toFloat() + 8f
			val open = (Math.random() * 6).toFloat() + 1f
			val close = (Math.random() * 6).toFloat() + 1f

			val odd = i%2 != 0
			yValsCandleStick.add(CandleEntry(i.toFloat(), value+high, value-low, if (!odd) value + open else value - open, if (odd) value - close else value + close))
		}

		val candleDataSet = CandleDataSet(yValsCandleStick, "first")
		candleDataSet.color = Color.rgb(80, 80, 80)
		candleDataSet.shadowColor = resources.getColor(android.R.color.holo_green_dark)
		candleDataSet.shadowWidth = 1f
		candleDataSet.decreasingColor = resources.getColor(android.R.color.holo_red_dark)
		candleDataSet.decreasingPaintStyle = Paint.Style.FILL

		candleDataSet.increasingColor = resources.getColor(android.R.color.holo_green_dark)
		candleDataSet.increasingPaintStyle = Paint.Style.FILL


		val candleData = CandleData(candleDataSet)
		candleStickChart.data = candleData

		val xval = candleStickChart.xAxis
		xval.position = XAxis.XAxisPosition.BOTTOM
		xval.valueFormatter = object : ValueFormatter() {
			override fun getFormattedValue(value: Float): String {
				return xvalue[value.toInt()]
			}
		}


		candleStickChart.invalidate()
	}
}
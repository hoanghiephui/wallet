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
		yValsCandleStick.add(CandleEntry(0f, 49151.66f, 48899.99f, 49000f, 49058.67f))
		yValsCandleStick.add(CandleEntry(1f, 49146.02f, 48840.84f, 48949.8f, 49000f))
		yValsCandleStick.add(CandleEntry(2f, 49222.54f, 48905.83f, 49157.65f, 48947.89f))
		yValsCandleStick.add(CandleEntry(3f, 49474.09f, 49109.58f, 49335.38f, 49149.15f))
		yValsCandleStick.add(CandleEntry(4f, 49500f, 49277.56f, 49314.68f, 49340.75f))
		yValsCandleStick.add(CandleEntry(5f, 49896.7f, 49252.85f, 49844.7f, 49314.67f))
		yValsCandleStick.add(CandleEntry(6f, 49894.47f, 49760.66f, 49765.13f, 49844.7f))
		yValsCandleStick.add(CandleEntry(7f, 49893.15f, 49604.31f, 49893.15f, 49737.15f))
		val size = xvalue.size

		for (i in 0 until size) {
			val mul = size + 10
			val value = (Math.random() * 100).toFloat() + mul
			val high = (Math.random() * 15).toFloat() + 9f
			val low = (Math.random() * 15).toFloat() + 8f
			val open = (Math.random() * 6).toFloat() + 1f
			val close = (Math.random() * 6).toFloat() + 1f

			val odd = i%2 != 0
			//yValsCandleStick.add(CandleEntry(i.toFloat(), value+high, value-low, if (!odd) value + open else value - open, if (odd) value - close else value + close))
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
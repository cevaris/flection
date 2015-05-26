package com.cevaris.trading.strategies

import java.io.File
import org.joda.time._
import com.cevaris.trading.models._
import com.github.tototoshi.csv._
import scala.io.Source
import java.net.URL


trait TradingSimulation {
  def sourceFilePath: String

  def stocksFromFile: Seq[Stock] = {
    val reader = CSVReader.open(new File(sourceFilePath))
    val document = reader.allWithHeaders()
    reader.close

    (document map {row: Map[String, String] =>
      for {
        date <- row.get("Date")
        close <- row.get("Close")
      } yield Stock(new DateTime(date).toInstant, Price(close.toDouble))
    }).flatten.sorted
  }

}

case class DefaultSimulation() extends TradingSimulation {

  def sourceFilePath: String = "src/main/resources/yahoo-400.csv"

}

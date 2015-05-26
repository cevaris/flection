package com.cevaris.trading.models

import org.joda.time._

case class Price(value: Double)

case class Stock(
  datetime: Instant,
  close: Price
)

object Stock {
  implicit def dateTimeOrdering: Ordering[Instant] =
    Ordering.fromLessThan(_ isBefore _)

  implicit val datetimeOrdering =
    Ordering.by { s: Stock => s.datetime }
}

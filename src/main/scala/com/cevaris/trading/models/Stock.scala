package com.cevaris.trading.models

import org.joda.time._

case class Price(value: Double)

case class Stock(datetime: Instant, close: Price)

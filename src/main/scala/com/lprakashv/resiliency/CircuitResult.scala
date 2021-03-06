package com.lprakashv.resiliency

import com.lprakashv.resiliency.CircuitResult.CircuitSuccess

trait CircuitResult[T] extends IterableOnce[T] with Product with Serializable {
  def isFailed: Boolean = this.toOption.isEmpty

  def isSuccess: Boolean = this.toOption.isDefined

  def toOption: Option[T] = this match {
    case CircuitSuccess(value) => Some(value)
    case _                     => None
  }
}

object CircuitResult {
  case class CircuitSuccess[T](value: T) extends CircuitResult[T] {
    override def iterator: Iterator[T] = Iterator.apply(value)
  }
  case class CircuitFailure[T](exception: Throwable) extends CircuitResult[T] {
    override def iterator: Iterator[T] = Iterator.empty[T]
  }
}

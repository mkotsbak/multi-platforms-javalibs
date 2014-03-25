package java.lang

class Boolean(private val value: scala.Boolean) extends Comparable[Boolean] {

  def this(v: String) = this(Boolean.parseBoolean(v))

  def booleanValue(): scala.Boolean = value

  override def equals(that: Any) =
    that.isInstanceOf[Boolean] && (value == that.asInstanceOf[Boolean].value)

  override def compareTo(that: Boolean): Int =
    if (value == that.value) 0 else if (value) 1 else -1

  override def toString: String = if (value) "true" else "false"

  override def hashCode = if (value) 1231 else 1237

  /*
   * Methods on scala.Boolean
   * The following methods are only here to properly support reflective calls
   * on boxed primitive values. YOU WILL NOT BE ABLE TO USE THESE METHODS, since
   * we use the true javalib to lookup symbols, this file contains only
   * implementations.
   */

  protected def unary_! : scala.Boolean = !value
  protected def ==(x: scala.Boolean): scala.Boolean = value == x
  protected def !=(x: scala.Boolean): scala.Boolean = value != x
  protected def ||(x: scala.Boolean): scala.Boolean = value || x
  protected def &&(x: scala.Boolean): scala.Boolean = value && x
  protected def |(x: scala.Boolean): scala.Boolean = value | x
  protected def &(x: scala.Boolean): scala.Boolean = value & x
  protected def ^(x: scala.Boolean): scala.Boolean = value ^ x

}

object Boolean {
  val TYPE = classOf[scala.Boolean]
  val TRUE = new Boolean(true)
  val FALSE = new Boolean(false)

  def valueOf(booleanValue: scala.Boolean): Boolean =
    if (booleanValue) TRUE else FALSE
  def valueOf(s: String): Boolean = valueOf(parseBoolean(s))

  def parseBoolean(s: String): scala.Boolean =
    (s != null) && s.equalsIgnoreCase("true")

  def toString(b: scala.Boolean): String = if (b) "true" else "false"
}

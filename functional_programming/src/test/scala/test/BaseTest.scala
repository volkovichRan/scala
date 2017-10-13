package test

import org.scalatest._

abstract class BaseTest extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors

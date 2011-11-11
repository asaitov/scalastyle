package org.segl.scalastyle

import _root_.org.segl.scalastyle.ScalariformChecker
import java.lang.reflect.Constructor;
import scalariform.parser.CompilationUnit
import _root_.scalariform.lexer.Tokens._

class SpacesAfterPlusChecker extends ScalariformChecker {
  def verify(file: String, ast: CompilationUnit): List[Message] = {
    val it = for (
      List(left, right) <- ast.tokens.sliding(2);
      if (left.tokenType == PLUS && left.startIndex + 1 == right.startIndex)
    ) yield {
      StyleError(file, "spaces.after.plus", position = Some(left.startIndex))
    }

    return it.toList
  }
}
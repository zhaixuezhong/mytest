package design_pattern;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhaixuezhong(2079) on 3/13/18.
 */


interface Expression {
  int interpret(final Map<String, Expression> variables);
}

class Number implements Expression {
  private int number;

  public Number(final int number) {
    this.number = number;
  }

  public int interpret(final Map<String, Expression> variables) {
    return number;
  }
}

class Plus implements Expression {
  Expression leftOperand;
  Expression rightOperand;

  public Plus(final Expression left, final Expression right) {
    leftOperand = left;
    rightOperand = right;
  }

  public int interpret(final Map<String, Expression> variables) {
    return leftOperand.interpret(variables) + rightOperand.interpret(variables);
  }
}

class Minus implements Expression {
  Expression leftOperand;
  Expression rightOperand;

  public Minus(final Expression left, final Expression right) {
    leftOperand = left;
    rightOperand = right;
  }

  public int interpret(final Map<String, Expression> variables) {
    return leftOperand.interpret(variables) - rightOperand.interpret(variables);
  }
}

class Variable implements Expression {
  private String name;

  public Variable(final String name) {
    this.name = name;
  }

  public int interpret(final Map<String, Expression> variables) {
    if (null == variables.get(name)) return 0; // Either return new Number(0).
    return variables.get(name).interpret(variables);
  }
}


class Evaluator implements Expression {
  private Expression syntaxTree;

  public Evaluator(final String expression) {
    final Stack<Expression> expressionStack = new Stack<>();
    for (final String token : expression.split(" ")) {
      if (token.equals("+")) {
        final Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
        expressionStack.push(subExpression);
      } else if (token.equals("-")) {
        // it's necessary remove first the right operand from the stack
        final Expression right = expressionStack.pop();
        // ..and after the left one
        final Expression left = expressionStack.pop();
        final Expression subExpression = new Minus(left, right);
        expressionStack.push(subExpression);
      } else
        expressionStack.push(new Variable(token));
    }
    syntaxTree = expressionStack.pop();
  }

  public int interpret(final Map<String, Expression> context) {
    return syntaxTree.interpret(context);
  }
}


public class InterpreterExample {
  public static void main(final String[] args) {
    final String expression = "w x z - +";
    final Evaluator sentence = new Evaluator(expression);
    final Map<String, Expression> numValue = new HashMap();
    numValue.put("w", new Number(5));
    numValue.put("x", new Number(10));
    numValue.put("z", new Number(42));
    final int result = sentence.interpret(numValue);
    System.out.println(result);
  }
}

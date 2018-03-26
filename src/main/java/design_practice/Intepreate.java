package design_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhaixuezhong(2079) on 3/14/18.
 */

interface Expression {
  int inspect(Map<String, Expression> expressionMap);
}

class Number implements Expression {
  private int value;

  public Number(int value) {
    this.value = value;
  }

  @Override
  public int inspect(Map<String, Expression> expressionMap) {
    return value;
  }
}


class Variable implements Expression {
  private String name;

  public Variable(String token) {
    this.name = token;
  }

  @Override
  public int inspect(Map<String, Expression> expressionMap) {
    if (null == expressionMap.get(name)) return 0; // Either return new Number(0).
    return expressionMap.get(name).inspect(expressionMap);
  }
}


class Minus implements Expression {
  private Expression left;
  private Expression right;

  public Minus(Expression right, Expression left) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int inspect(Map<String, Expression> expressionMap) {
    return left.inspect(expressionMap) - right.inspect(expressionMap);
  }
}


class Plus implements Expression {
  private Expression left;
  private Expression right;

  public Plus(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int inspect(Map<String, Expression> expressionMap) {
    return left.inspect(expressionMap) + right.inspect(expressionMap);
  }
}


class Evaluation implements Expression {
  final Stack<Expression> expressionStack = new Stack<>();
  Expression cutPoint = null;

  public Evaluation(String expression) {
    String[] split = expression.split(" ");

    for (int i = 0; i < split.length; i++) {
      String token = split[i];
      if ("+".equals(token)) {
        final Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
        expressionStack.push(subExpression);
      } else if ("-".equals(token)) {
        final Expression subExpression = new Minus(expressionStack.pop(), expressionStack.pop());
        expressionStack.push(subExpression);
      } else {
        expressionStack.push(new Variable(token));
      }
    }
    cutPoint = expressionStack.pop();
  }

  @Override
  public int inspect(Map<String, Expression> expressionMap) {
    return cutPoint.inspect(expressionMap);
  }

}

public class Intepreate {
  public static void main(final String[] args) {
    final String expression = "x y z - +";
    Expression evaluation = new Evaluation(expression);
    Map<String, Expression> expressionMap = new HashMap<>();
    expressionMap.put("x", new Number(10));
    expressionMap.put("y", new Number(11));
    expressionMap.put("z", new Number(12));
    int inspect = evaluation.inspect(expressionMap);
    System.out.println(inspect);
  }


}

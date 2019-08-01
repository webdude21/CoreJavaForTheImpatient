package corejava.generics.tests;

import corejava.generics.ArrayStack;
import corejava.generics.ListStack;
import corejava.generics.Stack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class StackTest {

  private static final int TEST_ELEMENT = 5;
  private static final int TEST_CAPACITY = 1200;
  private final Class<? extends Stack<Integer>> stackClass;
  private Stack<Integer> stack;

  public StackTest(Class<? extends Stack<Integer>> classToTest) {
    this.stackClass = classToTest;
  }

  @Parameters
  public static Collection<? extends Class<? extends Stack>> getParameters() {
    List<Class<? extends Stack>> classesToTest = new ArrayList<>();
    classesToTest.add(ListStack.class);
    classesToTest.add(ArrayStack.class);
    return classesToTest;
  }

  @Before
  public void setUp() throws Exception {
    this.stack = stackClass.getDeclaredConstructor().newInstance();
  }

  @Test
  public void InitialStackShouldBeEmpty() {
    assertThat(stack.isEmpty(), equalTo(true));
  }

  @Test
  public void PushingInTheStackWorksCorrectly() {
    this.stack.push(TEST_ELEMENT);
    assertThat(stack.peek(), equalTo(TEST_ELEMENT));
  }

  @Test
  public void PopingAnElementRemovesItFromTheStackAndReturnsIt() {
    this.stack.push(TEST_ELEMENT);
    assertThat(stack.pop(), equalTo(TEST_ELEMENT));
    assertThat(stack.isEmpty(), equalTo(true));
  }

  @Test(expected = IllegalStateException.class)
  public void CallingPopOnAnEmptyStackThrowsAnException() {
    this.stack.pop();
  }

  @Test(expected = IllegalStateException.class)
  public void CallingPeekOnAnEmptyStackThrowsAnException() {
    this.stack.peek();
  }

  @Test
  public void PushingManyElementsWorks() {
    for (int i = 0; i <= TEST_CAPACITY; i++) {
      this.stack.push(i);
    }

    for (int i = TEST_CAPACITY; i >= 0; i--) {
      assertThat(this.stack.pop(), equalTo(i));
    }

    assertThat(this.stack.isEmpty(), equalTo(true));
  }
}

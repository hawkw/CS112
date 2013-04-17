package net.datastructures;
//begin#fragment EmptyDequeException
/**
 * Runtime exception thrown when one tries to perform operation top or
 * pop on an empty deque.
//end#fragment EmptyDequeException
 * @author Roberto Tamassia
//begin#fragment EmptyDequeException
 */

public class EmptyDequeException extends RuntimeException {  
  public EmptyDequeException(String err) {
    super(err);
  }
}
//end#fragment EmptyDequeException

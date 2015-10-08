/**
 * Created by Donal on 07/10/2015.
 */
import java.net._
import java.io._
import scala.io._


object TCPClient {
  def main(args: Array[String]){
    val user_in = StdIn.readLine();

    val cs =  new Socket(InetAddress.getByName("localhost"), 8000);

    val in = new BufferedSource(cs.getInputStream()).getLines()
    val out = new PrintStream(cs.getOutputStream())

    out.println("GET /echo.php?message="+ user_in +" HTTP/1.0\r\n");

    while(in.hasNext){
    	println(in.next());
    }

    cs.close()
    
  }
}

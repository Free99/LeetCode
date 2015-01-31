/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    int offset = 0;
    int bufsize = 0;
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        int bytes = 0;
        while (!eof && readBytes<n) {
            if (bufsize==0) {
                bufsize = read4(buffer);
                eof = bufsize<4;
            }
            bytes = Math.min(n-readBytes, bufsize);
            for (int i=0; i<bytes; i++) {
                buf[readBytes+i] = buffer[offset+i];
            }
            offset = (offset+bytes)%4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}
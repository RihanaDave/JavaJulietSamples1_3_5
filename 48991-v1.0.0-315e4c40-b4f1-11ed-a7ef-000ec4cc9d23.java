/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_02.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_02 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (true)
        {
            String libName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String root = "C:\\libs\\";
            String libName = "test.dll";

            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);

        }
    }

    /* good1() changes true to false */
    private void good1() throws Throwable
    {
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String libName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);
        }
        else {

            String root = "C:\\libs\\";
            String libName = "test.dll";

            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(true)
        {
            String root = "C:\\libs\\";
            String libName = "test.dll";
            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String libName = "test.dll";

            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicklink;


/**
 *
 * @author shahrear.iqbal
 */
public class ClickLink {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
        TestClassAdsense tc = new TestClassAdsense();
        tc.testMethod();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}

/**
 **/
package com.jgaap.eventDrivers;

import com.jgaap.generics.Document;
import com.jgaap.generics.EventSet;
import com.jgaap.generics.EventDriver;
import com.jgaap.jgaapConstants;
import javax.swing.*;


/**
 * Truncate lexical frequency for discrete binning 
 *
 */
public class TruncatedNamingTimeEventDriver extends EventDriver {

    @Override
    public String displayName(){
    	return "Binned naming times";
    }
    
    @Override
    public String tooltipText(){
    	return "Discretized (by truncation) ELP naming latencies";
    }
    
    @Override
    public boolean showInGUI(){
    	return jgaapConstants.globalParams.getParameter("language").equals("english");
    }

    @Override
    public GroupLayout getGUILayout(JPanel panel){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        return layout;
    }

    private EventDriver theDriver;

    @Override
    public EventSet createEventSet(Document ds) {
        theDriver = new TruncatedEventDriver();
        theDriver.setParameter("length", "2");
        theDriver.setParameter("underlyingEvents", "NamingTimeEventDriver");
        return theDriver.createEventSet(ds);
    }
}

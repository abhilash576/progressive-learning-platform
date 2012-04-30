/*
    Copyright 2012 PLP Contributors

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

package plptool.extras.flowchart;

import plptool.*;
import plptool.gui.ProjectDriver;
import plptool.gui.ProjectEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author wira
 */
public class PLPToolConnector implements PLPGenericModule {
    private ProjectDriver plp;
    private boolean processed = false;
    private PLPCPUProgram flowchart;
    private ExportDOT frame;

    public Object hook(Object param) {
        if(param instanceof ProjectDriver) {
            this.plp = (ProjectDriver) param;
            init();
        } else if(param instanceof String) {
            String cmd = (String) param;
            if(cmd.equals("process")) {
                if(plp.isAssembled()) {
                    flowchart = new PLPCPUProgram(plp);
                    processed = true;
                }
            } else if(cmd.equals("print")) {
                if(flowchart != null)
                    for(int i = 0; i < flowchart.getNumberOfRoutines(); i++)
                        flowchart.printProgram(i);
            } else if(cmd.equals("dot")) {
                if(processed) {
                    for(int i = 0; i < flowchart.getNumberOfRoutines(); i++) {
                        Msg.I("Flowchart for " + flowchart.getRoutine(i).getHead().getLabel(), this);
                        Msg.P(flowchart.generateDOT(i));
                    }
                }
            }
        } else if(param instanceof ProjectEvent) {
            ProjectEvent ev = (ProjectEvent) param;
            switch(ev.getIdentifier()) {
                case ProjectEvent.NEW_PROJECT:
                case ProjectEvent.PROJECT_OPEN:
                    processed = false;
            }
        }

        return null;
    }

    private void init() {
        Msg.I("<em>Flowchart Generator</em> is ready &mdash; This module can be accessed through the <b>Tools" +
                "</b>&rarr;<b>Flowchart Generator</b> menu",
                null);
        frame = new ExportDOT(plp.g_dev);
        JMenu menuFlowchart = new JMenu("Flowchart Generator");
        JMenuItem menuFlowchartGenerator = new JMenuItem("Save program routine as a .DOT file...");
        menuFlowchartGenerator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(plp.isAssembled()) {
                    flowchart = new PLPCPUProgram(plp);
                    frame.update(flowchart);
                    frame.setVisible(true);
                }
            }
        });
        menuFlowchart.add(menuFlowchartGenerator);
        plp.g_dev.addToolsItem(menuFlowchart);
    }

    @Override
    public String toString() {
        return "Flowchart Generator";
    }

    public String getVersion() {
        return "0.1";
    }
}

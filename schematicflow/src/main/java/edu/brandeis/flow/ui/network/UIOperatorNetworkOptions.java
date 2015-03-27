package edu.brandeis.flow.ui.network;

import org.vaadin.visjs.networkDiagram.options.Options;
import org.vaadin.visjs.networkDiagram.options.physics.BarnesHut;
import org.vaadin.visjs.networkDiagram.options.physics.Physics;
import org.vaadin.visjs.networkDiagram.options.physics.Repulsion;

class UIOperatorNetworkOptions extends Options {
	protected UIOperatorNetworkOptions(){
		super();
		Physics physics = new Physics();
        Repulsion repulsion = new Repulsion();
        repulsion.setCentralGravity((float) 0.0);
        repulsion.setNodeDistance(167);
        repulsion.setDamping((float) 0.3);
        repulsion.setSpringConstant((float) 0.0);
        repulsion.setSpringLength(0);
        BarnesHut bh = new BarnesHut();
        bh.setEnabled(false);
        physics.setRepulsion(repulsion);
        physics.setBarnesHut(bh);
        setPhysics(physics);
	}
}

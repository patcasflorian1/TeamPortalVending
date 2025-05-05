package org.eurovending.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.eurovending.model.MachineInterface;


import java.util.List;

import javax.transaction.Transactional;
@Component
public class MachineInterfaceDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    // Create a new machine interface
    @Transactional
    public void createMachineInterface(MachineInterface machine) {
		this.hibernateTemplate.saveOrUpdate(machine);
	}
    // Get all machine interfaces
    public List<MachineInterface> getAllMachineInterfaces() {
		List<MachineInterface> machineInterfaces = this.hibernateTemplate.loadAll(MachineInterface.class);
		return machineInterfaces;
	}
    // Delete a single machine interface
    @Transactional
    public void deleteMachineInterface(int id) {
    	
    			MachineInterface machine = this.hibernateTemplate.load(MachineInterface.class, id);
    			this.hibernateTemplate.delete(machine);
    			
    }
    // Get a single machine interface
    @Transactional
    public MachineInterface getSingleMachineInterface(int id) {
    	
		return this.hibernateTemplate.get(MachineInterface.class, id);
	}
    
    // Update a machine interface
    @Transactional
	public void updateMachineInterface(MachineInterface machine) {
		this.hibernateTemplate.update(machine);
	}
	
	// Get a machine interface by MAC address
    @Transactional
	public MachineInterface getMachineInterfaceByMac(String mac) {
		List<MachineInterface> machines = (List<MachineInterface>) this.hibernateTemplate.find("from MachineInterface where macMachine=?", mac);
		if (machines.size() > 0) {
			return machines.get(0);
		} else {
			return null;
		}
	}
}

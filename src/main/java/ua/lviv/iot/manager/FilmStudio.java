package ua.lviv.iot.manager;

import ua.lviv.iot.models.Decorations;
import ua.lviv.iot.models.Equipment;
import ua.lviv.iot.models.EquipmentBox;

import java.util.*;
import java.util.stream.Collectors;

public class FilmStudio {
	List<Equipment> equipmentList = new ArrayList<>();

	public void addNewEquipment(EquipmentBox ... equipmentBoxes){
		for (EquipmentBox equipmentBox : equipmentBoxes) {
			for(int i = 0; i < equipmentBox.numberOfItems(); ++i)
				equipmentList.add(equipmentBox.equipment());
		}
	}

	public void printEquipment() {
		Set<Equipment> equipmentSet = new LinkedHashSet<>(equipmentList);
		for (Equipment equipment : equipmentSet) {
			System.out.println(equipment);
		}
	}

	public Set<Equipment> getEquipmentSortedByPrice(boolean reverse){
		Set<Equipment> result = equipmentList.stream().sorted(Comparator.comparingDouble(Equipment::getPriceInUAH))
				.collect(Collectors.toCollection(LinkedHashSet::new));
		if(reverse) {
			List<Equipment> list = new ArrayList<>(result);
			Collections.reverse(list);
			result = new LinkedHashSet<>(list);
		}
		return result;
	}

	public Set<Equipment> getRentedEquipment(){
		return equipmentList.stream().filter(Equipment::isRented).collect(Collectors.toSet());
	}

	public Set<Decorations> getDecorationsByGenre(String genre){
		Set<Decorations> result = new HashSet<>();
		equipmentList.stream().filter(item -> item.getClass().getTypeName().equals("ua.lviv.iot.models.Decorations"))
				.filter(decoration -> ((Decorations)decoration).getFilmGenre().equals(genre.toLowerCase()))
				.forEach(decoration -> result.add((Decorations) decoration));
		return result;
	}

	public Set<Equipment> getEquipmentSortedByManufacturer(boolean reverse){
		Set<Equipment> result = equipmentList.stream().sorted(Comparator.comparing(Equipment::getManufacturer))
				.collect(Collectors.toCollection(LinkedHashSet::new));
		if(reverse) {
			List<Equipment> list = new ArrayList<>(result);
			Collections.reverse(list);
			result = new LinkedHashSet<>(list);
		}
		return result;
	}
}

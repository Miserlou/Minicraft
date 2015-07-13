package com.mojang.ld22.entity;

import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;

public class Inventory {
	public List<Item> items = new ArrayList<Item>();
	public static List<Item> items1 = new ArrayList<Item>();
	public int itemCount = items.size();


	public void add(Item item) {
		add(items.size(), item);
	}

	public void add(int slot, Item item) {
		itemCount = items.size();
		if (item instanceof ResourceItem) {
			ResourceItem toTake = (ResourceItem) item;
			ResourceItem has = findResource(toTake.resource);
			if (has == null) {
				items.add(slot, toTake);
				items1.add(slot, toTake);
			} else {
				has.count += toTake.count;
			}
		} else {
			items.add(slot, item);
			items1.add(slot, item);
		}
	}

	private ResourceItem findResource(Resource resource) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof ResourceItem) {
				ResourceItem has = (ResourceItem) items.get(i);
				if (has.resource == resource) return has;
			}
		}
		return null;
	}
	private static ResourceItem findResource1(Resource resource) {
		for (int i = 0; i < items1.size(); i++) {
			if (items1.get(i) instanceof ResourceItem) {
				ResourceItem has = (ResourceItem) items1.get(i);
				if (has.resource == resource) return has;
			}
		}
		return null;
	}

	public boolean hasResources(Resource r, int count) {
		ResourceItem ri = findResource(r);
		if (ri == null) return false;
		return ri.count >= count;
	}

	public boolean removeResource(Resource r, int count) {
		ResourceItem ri = findResource(r);
		if (ri == null) return false;
		if (ri.count < count) return false;
		ri.count -= count;
		if (ri.count <= 0) items.remove(ri);
		return true;
	}

	public int count(Item item) {
		if (item instanceof ResourceItem) {
			ResourceItem ri = findResource(((ResourceItem)item).resource);
			if (ri!=null) return ri.count;
		} else {
			int count = 0;
			for (int i=0; i<items.size(); i++) {
				if (items.get(i).matches(item)) count++;
			}
			return count;
		}
		return 0;
	}

	public static int count1(Item item) {
		if (item instanceof ResourceItem) {
			ResourceItem ri = findResource1(((ResourceItem)item).resource);
			if (ri!=null) return ri.count;
		} else {
			int count = 0;
			for (int i=0; i<items1.size(); i++) {
				if (items1.get(i).matches(item)) count++;
			}
			return count;
		}
		return 0;
	}
}

package de.congrace.jaxb;

import java.net.URI;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.congrace.model.Context;
import de.congrace.model.Identifier;
import de.congrace.model.Item;

public class ItemAdapter extends XmlAdapter<ItemAdapter.ItemValue, Item> {

	@Override
	public ItemValue marshal(Item v) throws Exception {
		ItemValue val=new ItemValue();
		val.id = v.getId();
		val.name=v.getName();
		val.context=v.getContext();
		val.location=v.getLocation();
		return val;
	}

	@Override
	public Item unmarshal(ItemValue v) throws Exception {
		return new Item.Builder(v.name, v.context)
			.id(v.id)
			.location(v.location)
			.build();
	}

	static final class ItemValue {
		private Identifier id;
		private String name;
		private Context context;
		private URI location;

		private ItemValue() {
			super();
		}
	}
}

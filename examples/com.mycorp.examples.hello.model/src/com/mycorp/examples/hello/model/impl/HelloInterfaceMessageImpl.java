package com.mycorp.examples.hello.model.impl;

import com.mycorp.examples.hello.model.IHelloInterfaceMessage;

public class HelloInterfaceMessageImpl implements IHelloInterfaceMessage {

	private String from;
	private String message;
    private String description;

	public HelloInterfaceMessageImpl() {
	}

	public HelloInterfaceMessageImpl(String from, String message) {
		this.from = from;
		this.message = message;
	}

    public HelloInterfaceMessageImpl(String from, String message, String description) {
        this.from = from;
        this.message = message;
        this.description = description;
    }

	/* (non-Javadoc)
	 * @see com.mycorp.examples.hello.model.IHelloInterfaceMessage#getFrom()
	 */
	@Override
	public String getFrom() {
		return from;
	}

	/* (non-Javadoc)
	 * @see com.mycorp.examples.hello.model.IHelloInterfaceMessage#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
     * @see com.mycorp.examples.hello.model.IHelloInterfaceMessage#getDescription()
     */

    @Override
    public String getDescription() {
        return description;
    }

}

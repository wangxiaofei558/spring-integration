/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.samples.cafe;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

/**
 * @author Mark Fisher
 */
@Component
public class Barista {

	private long hotDrinkDelay = 2000;

	private long coldDrinkDelay = 1000; 

	private AtomicInteger hotDrinkCounter = new AtomicInteger();
	
	private AtomicInteger coldDrinkCounter = new AtomicInteger();


	public void setHotDrinkDelay(long hotDrinkDelay) {
		this.hotDrinkDelay = hotDrinkDelay;
	}

	public void setColdDrinkDelay(long coldDrinkDelay) {
		this.coldDrinkDelay = coldDrinkDelay;
	}

	public void prepareHotDrink(Drink drink) {
		try {
			Thread.sleep(this.hotDrinkDelay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("prepared hot drink #" + hotDrinkCounter.incrementAndGet() + ": " + drink);
	}

	public void prepareColdDrink(Drink drink) {
		try {
			Thread.sleep(this.coldDrinkDelay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("prepared cold drink #" + coldDrinkCounter.incrementAndGet() + ": " + drink);
	}

}

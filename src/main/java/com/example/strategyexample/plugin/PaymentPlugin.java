package com.example.strategyexample.plugin;

import com.example.strategyexample.PaymentType;
import org.springframework.plugin.core.Plugin;

public interface PaymentPlugin extends Plugin<PaymentType> {

  void process();
}

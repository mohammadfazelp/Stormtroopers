package com.faz.stormtroopers.di.qualifier;


import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;

@MapKey
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}

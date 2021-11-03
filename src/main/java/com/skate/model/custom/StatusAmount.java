package com.skate.model.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Andres Gomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusAmount {
   private int completed;
   private int cancelled; 
}

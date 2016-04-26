; Cycles are like a heart beat, the next starts just when the previous ends.
; Unlike durations, they have an absolute position in the time, it's just that this position is periodic.
; Examples of phrases involving cycles:
; - this week
; - today (= this day)
; - last month
; - last 2 calendar months (last 2 months is interpreted as a duration)
;
; As soon as you put a quantity (2 months), the cycle becomes a duration.


(
  "sekunda (cycle)"
  #"(?i)sekund(y|zie|ę|e|ą|om|ami|ach|a)?"
  {:dim :cycle
   :grain :second}

  "minuta (cycle)"
  #"(?i)minucie|minut(y|ę|e|ą|om|ami|ach|a)?"
  {:dim :cycle
   :grain :minute}

  "godzina (cycle)"
  #"(?i)godzin(y|ie|ę|e|ą|om|ami|ach|a)?"
  {:dim :cycle
   :grain :hour}

  "dzień (cycle)"
  #"(?i)dzie[ńn]|dni(ami|ach|a|owi|u|om|em|e)?"
  {:dim :cycle
   :grain :day}

  "tydzień (cycle)"
  #"(?i)tydzie[ńn]|tygodni(ami|ach|a|owi|u|om|em|e)?"
  {:dim :cycle
   :grain :week}

  "miesiąc (cycle)"
  #"(?i)miesi[ęe]cy|miesi[ąa]c(ami|ach|a|om|owi|em|e|y|u)?"
  {:dim :cycle
   :grain :month}

  "kwartał (cycle)"
  #"(?i)kwarta[łl](u|owi|em|y|[óo]w|ami|ach|om)|kwartale"
  {:dim :cycle
   :grain :quarter}
  
  "year (cycle)"
  #"(?i)rok(u|owi|iem)?|lat(ami|ach|a|y|om)?"
  {:dim :cycle
   :grain :year}

  "w tym <cycle>"
  [#"(?i)w (dok[łl]adnie )?t(ym|ej|ych)" (dim :cycle)]
  (cycle-nth (:grain %2) 0)

  "w zeszłym <cycle>"
  [#"(?i)w zeszł(ym|ej|ych)" (dim :cycle)]
  (cycle-nth (:grain %2) -1)

  "<cycle> temu"
  [(dim :cycle) #"(?i)temu"]
  (cycle-nth (:grain %1) -1)

)

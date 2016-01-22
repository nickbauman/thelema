(ns thelema.test-runner
 (:require [doo.runner :refer-macros [doo-tests]]
           [thelema.core-test]))

(doo-tests
 'thelema.core-test)

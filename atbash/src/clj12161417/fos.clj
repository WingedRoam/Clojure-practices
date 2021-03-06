(ns clj12161417.fos)

(defn lmap  [f xs](letfn[(r [as bs g]
                             (if (empty? as)
                               bs
                               (r (butlast as) (cons (g (last as)) bs) g)
                               )
                             )]
                      (r xs '() f))  )

(defn smap [f xs](letfn[(r [as bs g]
                             (if (empty? as)
                               bs
                               (r (rest as) (str bs (g (first as))) g)
                               )
                             )]
                      (r xs "" f)))  


(defn vmap [f xs](letfn[(r [as bs g]
                             (if (empty? as)
                               bs
                               (r (rest as) (conj bs (g (first as))) g)
                               )
                             )]
                      (r xs [] f)))  

(defn vreduce [vi f xs] 
               (letfn [(r [as vf g]
                         (if (empty? as)
                           vf
                           (r (rest as) 
                           (g vf (first as)) 
                           g))
                         )] (r xs vi f)))

